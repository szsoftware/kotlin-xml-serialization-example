package com.github.szsoftware.sample.libmodelexamples

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlChildrenName
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("group", "", "")
class MyExampleGroup() {

        @XmlChildrenName("person", "", "")
        var persons = mutableListOf<MyExamplePerson>()

}
