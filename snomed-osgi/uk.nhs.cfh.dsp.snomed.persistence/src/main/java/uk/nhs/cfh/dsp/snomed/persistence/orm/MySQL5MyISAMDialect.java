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
package uk.nhs.cfh.dsp.snomed.persistence.orm;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * A custom {@link org.hibernate.dialect.MySQL5Dialect} that uses MyISAM engine for MySQL version 5 +
 *
 * <br>Version : @#VersionNumber#@
 * <br>Written by @author Jay Kola
 * <br>Created on Jan 20, 2011 at 7:40:59 PM
 */
public class MySQL5MyISAMDialect extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=MyISAM";
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }
}
