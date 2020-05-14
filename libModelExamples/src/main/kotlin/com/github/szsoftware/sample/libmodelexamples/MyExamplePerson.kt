package com.github.szsoftware.sample.libmodelexamples

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("person", "", "")
public class MyExamplePerson(

        @XmlElement(true)
        var firstname: String,

        @XmlElement(true)
        var lastname: String
)
