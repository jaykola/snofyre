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
package uk.nhs.cfh.dsp.srth.information.model.om.clinical;

/**
 * An enumeration of base expression types that are generated using a
 * {@link uk.nhs.cfh.dsp.snomed.objectmodel.SnomedConcept}, a
 * {@link uk.nhs.cfh.dsp.snomed.expression.model.NormalFormExpression} or a
 * {@link uk.nhs.cfh.dsp.snomed.expression.model.CloseToUserExpression}.
 *
 * <br>Version : @#VersionNumber#@
 * <br>Written by @author Jay Kola
 * <br>Created on Jan 19, 2010 at 8:10:18 PM
 */
public enum ClinicalExpressionType {

    FINDING_WEC, OBSERVATION_WEC, PROCEDURE_WEC, EVALUATION_PROCEDURE_WEC, EVENT_WEC, MEDICATION_PROCEDURE,
    INVESTIGATION_PROCEDURE, GENERIC_PROCEDURE, BODY_STRUCTURE
}
