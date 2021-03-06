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
package uk.nhs.cfh.dsp.srth.desktop.modularframework;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * An interface specification for a service that registers and manages
 * {@link uk.nhs.cfh.dsp.srth.desktop.modularframework.ActionComponent}s.
 * 
 * <br>Version : @#VersionNumber#@
 * <br>Written by @author jay
 * <br>Created on Nov 24, 2009 at 2:02:16 PM
 */
public interface ActionComponentService {

    /**
     * Register action component.
     *
     * @param actionComponent the action component
     */
    void registerActionComponent(ActionComponent actionComponent);

    /**
     * Unregister action component.
     *
     * @param actionComponent the action component
     */
    void unregisterActionComponent(ActionComponent actionComponent);

    /**
     * Gets the components.
     *
     * @return the components
     */
    List<ActionComponent> getComponents();

    /**
     * Sets the components.
     *
     * @param components the new components
     */
    void setComponents(List<ActionComponent> components);

    /**
     * Gets the listeners.
     *
     * @return the listeners
     */
    List<ActionComponentServiceListener> getListeners();

    /**
     * Sets the listeners.
     *
     * @param listeners the new listeners
     */
    void setListeners(List<ActionComponentServiceListener> listeners);

    /**
     * Adds the listener.
     *
     * @param listener the listener
     */
    void addListener(ActionComponentServiceListener listener);

    /**
     * Removes the listener.
     *
     * @param listener the listener
     */
    void removeListener(ActionComponentServiceListener listener);
}
