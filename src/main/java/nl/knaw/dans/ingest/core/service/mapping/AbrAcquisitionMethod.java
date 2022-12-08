/*
 * Copyright (C) 2022 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.ingest.core.service.mapping;

import lombok.extern.slf4j.Slf4j;
import nl.knaw.dans.ingest.core.service.XmlReader;
import org.w3c.dom.Node;

@Slf4j
public class AbrAcquisitionMethod extends Base {
    public static String toVerwervingswijze(Node node) {
        return getAttribute(node, XmlReader.NAMESPACE_DDM, "valueURI")
            .map(Node::getTextContent)
            .orElseGet(() -> {
                log.error("Missing valueURI attribute on ddm:acquisitionMethod node");
                return null;
            });
    }
}
