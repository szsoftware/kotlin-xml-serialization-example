package model

import com.github.szsoftware.sample.libmodelexamples.MyExampleGroup
import com.github.szsoftware.sample.libmodelexamples.MyExamplePerson
import com.github.szsoftware.sample.libmodelexamples.MyExampleSerializableModel
import nl.adaptivity.xmlutil.XmlDeclMode
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

    val group = MyExampleGroup()

    init {
        group.persons.add(MyExamplePerson("Linus", "Torvalds"))
        group.persons.add(MyExamplePerson("Bill", "Gates"))
    }

    @Test fun `can instantiate a model`() {
        val model = MyExampleSerializableModel
        assertNotNull(model)
    }

    @Test fun `can serialize a model`() {

        val expectedXml = """<prefix:model xmlns:prefix="namespace" version="0.0.1" anAttribute="attrValue"><prefix:anElement>elementValue</prefix:anElement><prefix:aBlankElement></prefix:aBlankElement></prefix:model>"""

        val model = MyExampleSerializableModel()
        val format = XML

        val serializedModel = format.stringify(MyExampleSerializableModel.serializer(), model)

        assertEquals(serializedModel, expectedXml)
    }

    @Test fun `can serialize with xml-declaration`() {

        val expectedXml = """
            <?xml version="1.0" encoding="UTF-8"?>
            <prefix:model xmlns:prefix="namespace" version="0.0.1" anAttribute="attrValue">
                <prefix:anElement>elementValue</prefix:anElement>
                <prefix:aBlankElement></prefix:aBlankElement>
            </prefix:model>"""

        val model = MyExampleSerializableModel()

        val format = XML {
                xmlDeclMode  = XmlDeclMode.Charset
                indentString = " ".repeat(4)
        }

        val serializedModel = format.stringify(MyExampleSerializableModel.serializer(), model)

        assertEquals(expectedXml.trimIndent(), serializedModel)
    }

    @Test fun `can instantiate a person model`() {

        val expectedXml = "<person><firstname>Sven</firstname><lastname>Zahrend</lastname></person>"

        val person = MyExamplePerson("Sven", "Zahrend")
        val format = XML

        val serializedModel = format.stringify(MyExamplePerson.serializer(), person)

        assertNotNull(person)
        assertEquals(expectedXml, serializedModel)
    }

    @Test fun `can instantiate a group model`() {

        assertNotNull(group)
        assertEquals(2, group.persons.size)
    }

    @Test fun `can serialize a group model with a list of persons`() {

        val expectedXml = """
            <group><persons><person><firstname>Linus</firstname><lastname>Torvalds</lastname></person><person><firstname>Bill</firstname><lastname>Gates</lastname></person></persons></group>
            """

        val format = XML
        val serializedModel = format.stringify(MyExampleGroup.serializer(), group)

        assertEquals(expectedXml.trimIndent(), serializedModel)
    }

    @Test fun `can serialize with indentation`() {

        val expectedXml = """
        <group>
            <persons>
                <person>
                    <firstname>Linus</firstname>
                    <lastname>Torvalds</lastname>
                </person>
                <person>
                    <firstname>Bill</firstname>
                    <lastname>Gates</lastname>
                </person>
            </persons>
        </group>"""

        val format = XML {
            indentString = " ".repeat(4)
        }

        val serializedModel = format.stringify(MyExampleGroup.serializer(), group)

        assertEquals(expectedXml.trimIndent(), serializedModel)
    }
}