/**
 * Crown Copyright (C) 2008 - 2011
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package uk.nhs.cfh.dsp.srth.demographics.impl;

import uk.nhs.cfh.dsp.srth.demographics.DemographicsEntityFactory;
import uk.nhs.cfh.dsp.srth.demographics.person.Patient;
import uk.nhs.cfh.dsp.srth.demographics.person.Person;
import uk.nhs.cfh.dsp.srth.demographics.person.impl.PatientImpl;
import uk.nhs.cfh.dsp.srth.demographics.person.impl.PersonImpl;

// TODO: Auto-generated Javadoc
/**
 * A concrete implementation of a {@link uk.nhs.cfh.dsp.srth.demographics.DemographicsEntityFactory}
 *
 * @scr.component immediate=“true”
 * @scr.service
 *
 * <br>Version : @#VersionNumber#@
 * <br>Written by @author Jay Kola
 * <br>Created on Oct 28, 2009 at 9:48:57 AM
 */

public class DemographicsEntityFactoryImpl implements DemographicsEntityFactory {

	/**
	 * Instantiates a new demographics entity factory impl.
	 */
	public DemographicsEntityFactoryImpl() {

	}

	/* (non-Javadoc)
	 * @see uk.nhs.cfh.dsp.srth.demographics.DemographicsEntityFactory#getPerson()
	 */
	/**
	 * Gets the person.
	 * 
	 * @return the person
	 */
	public Person getPerson(){
		return new PersonImpl();
	}
	
	/* (non-Javadoc)
	 * @see uk.nhs.cfh.dsp.srth.demographics.DemographicsEntityFactory#getPatient()
	 */
	/**
	 * Gets the patient.
	 * 
	 * @return the patient
	 */
	public Patient getPatient(){
		return new PatientImpl();
	}

    /* (non-Javadoc)
     * @see uk.nhs.cfh.dsp.srth.demographics.DemographicsEntityFactory#getPatient(java.lang.String)
     */
    public Patient getPatient(String patientID){
        return new PatientImpl(Long.valueOf(patientID));
    }
}
