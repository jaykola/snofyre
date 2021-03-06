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
package uk.nhs.cfh.dsp.srth.desktop.appservice;

//import uk.nhs.cfh.dsp.srth.desktop.appservice.ApplicationService;

import org.jdesktop.application.Application;
import uk.nhs.cfh.dsp.srth.desktop.modularframework.ActionComponentService;
import uk.nhs.cfh.dsp.srth.desktop.modularframework.ViewComponentService;

// TODO: Auto-generated Javadoc
/**
 * <br>Version : @#VersionNumber#@
 * <br>Written by @author Jay Kola
 * <br>Created on Jul 9, 2010 at 9:41:22 AM.
 */
public interface MDockingApplication {

    /**
     * Sets the view component service.
     *
     * @param viewComponentService the new view component service
     */
    void setViewComponentService(ViewComponentService viewComponentService);

    /**
     * Sets the action component service.
     *
     * @param actionComponentService the new action component service
     */
    void setActionComponentService(ActionComponentService actionComponentService);

    /**
     * Sets the application service.
     *
     * @param applicationService the new application service
     */
    void setApplicationService(ApplicationService applicationService);

    /**
     * Gets the view component service.
     *
     * @return the view component service
     */
    ViewComponentService getViewComponentService();

    /**
     * Gets the action component service.
     *
     * @return the action component service
     */
    ActionComponentService getActionComponentService();

    /**
     * Gets the application service.
     *
     * @return the application service
     */
    ApplicationService getApplicationService();

    /**
     * Gets the active application.
     *
     * @return the active application
     */
    Application getActiveApplication();
}
