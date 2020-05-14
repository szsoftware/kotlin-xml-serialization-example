package model

import com.github.szsoftware.sample.libmodelexamples.MyExampleSerializableModel
import nl.adaptivity.xmlutil.serialization.XML
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 *
 *
 *  @author szsoftware
 */
class ExampleModelTest {

    @Test fun `can instantiate sample model`() {

        val model = MyExampleSerializableModel
        assertNotNull(model)
    }

    @Test fun `can serialize model`() {

        val expectedXml = "<prefix:model xmlns:prefix=\"namespace\" version=\"0.0.1\" anAttribute=\"attrValue\"><prefix:anElement>elementValue</prefix:anElement><prefix:aBlankElement></prefix:aBlankElement></prefix:model>"

        val model = MyExampleSerializableModel()
        val format = XML()

        val serializedModel = format.stringify(MyExampleSerializableModel.serializer(), model)

        assertEquals(serializedModel, expectedXml)
    }
}