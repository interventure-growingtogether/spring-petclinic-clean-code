/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.vet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.SerializationUtils;

/**
 * @author Dave Syer
 *
 */
public class VetTests {

    private Vet vet;

    @Test
    public void testSerialization() {
        Vet other = (Vet) SerializationUtils
                .deserialize(SerializationUtils.serialize(vet));
        assertThat(other.getFirstName()).isEqualTo(vet.getFirstName());
        assertThat(other.getLastName()).isEqualTo(vet.getLastName());
        assertThat(other.getId()).isEqualTo(vet.getId());
    }

    @Test
    public void testAddSpeciality() {
        assertThat(vet.getSpecialties().size()).isEqualTo(0);
/*
        Specialty s = new Specialty();
        s.setName("oftamology");
        vet.getSpecialties().add(s);
        assertThat(vet.getSpecialties().size()).isEqualTo(1);
*/
    }

    @Before
    public void setup() {
        vet = new Vet();
        vet.setFirstName("Zaphod");
        vet.setLastName("Beeblebrox");
        vet.setId(123);
    }

}
