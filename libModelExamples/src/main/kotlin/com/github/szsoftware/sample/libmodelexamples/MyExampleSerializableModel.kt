package com.github.szsoftware.sample.libmodelexamples

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("model", "namespace", "prefix")
public class MyExampleSerializableModel(var version: String = "0.0.1") {

    var anAttribute = "attrValue"

    @XmlElement(true)
    var anElement = "elementValue"

    @XmlElement(true)
    var aBlankElement = ""

}
