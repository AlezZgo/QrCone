package com.example.qrcone.core

import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.IOException

class AbstractTest {

    @Test
    fun test_data_to_domain_success() {
        val dataObject = TestDataObject.Success("a", "b")
        val domainObject = dataObject.map(DataMapper.Base())
        assertTrue(domainObject is TestDomainObject.Success)
    }

    @Test
    fun test_fail() {
        val dataObject = TestDataObject.Fail(IOException())
        val domainObject = dataObject.map(DataMapper.Base())
        assertTrue(domainObject is TestDomainObject.Fail)
    }

    sealed class TestDataObject : Abstract.Object<TestDomainObject, DataMapper> {
        abstract override fun map(mapper: DataMapper): TestDomainObject

        class Success(
            private val textOne: String,
            private val textTwo: String,
        ) : TestDataObject() {
            override fun map(mapper: DataMapper): TestDomainObject {
                return mapper.map(textOne, textTwo)
            }
        }

        class Fail(private val exception: Exception) : TestDataObject() {
            override fun map(mapper: DataMapper): TestDomainObject {
                return mapper.map(exception)
            }
        }
    }

    sealed class TestDomainObject : Abstract.Object<TestUiObject, DomainMapper> {

        class Success(private val textCombined: String) : TestDomainObject() {
            override fun map(mapper: DomainMapper): TestUiObject {
                return mapper.map(textCombined)
            }
        }

        class Fail(private val exception: Exception) : TestDomainObject() {
            override fun map(mapper: DomainMapper): TestUiObject {
                return mapper.map(exception)
            }
        }
    }

    interface DataMapper : Abstract.Mapper {

        fun map(textOne: String, textTwo: String): TestDomainObject

        fun map(exception: Exception): TestDomainObject

        class Base : DataMapper {
            override fun map(textOne: String, textTwo: String): TestDomainObject {
                return TestDomainObject.Success("$textOne $textTwo")
            }

            override fun map(exception: Exception): TestDomainObject {
                return TestDomainObject.Fail(exception)
            }
        }
    }

    interface DomainMapper : Abstract.Mapper{
        fun map(combinedText: String): TestUiObject

        fun map(exception: Exception): TestUiObject
    }

    sealed class TestUiObject : Abstract.Object<Unit, Abstract.Mapper.Empty>
}