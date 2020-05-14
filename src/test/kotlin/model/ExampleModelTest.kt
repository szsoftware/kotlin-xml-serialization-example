package model

import com.github.szsoftware.sample.libmodelexamples.MyExampleSerializableModel
import kotlin.test.Test
import kotlin.test.assertNotNull

/**
 *
 *
 *  @author szsoftware
 */
class ExampleModelTest {

    @Test fun `can intantiate sample model`() {

        val model = MyExampleSerializableModel
        assertNotNull(model)
    }

}