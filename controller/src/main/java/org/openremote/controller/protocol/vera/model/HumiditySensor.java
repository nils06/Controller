/*
 * OpenRemote, the Home of the Digital Home. Copyright 2008-2015, OpenRemote Inc.
 * 
 * See the contributors.txt file in the distribution for a full listing of individual contributors.
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.openremote.controller.protocol.vera.model;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;
import org.openremote.controller.protocol.vera.VeraClient;
import org.openremote.controller.protocol.vera.VeraCmd;


public class HumiditySensor extends VeraDevice {

   protected Float humidity;
   
   public HumiditySensor(VeraCategory category, int id, String name, VeraClient client) {
      super(category, id, name, client);
   }

   @Override
   protected void updateDeviceSpecificSensors() {
      if ((attachedSensors.get(VeraCmd.GET_HUMIDITY) != null) && (humidity != null)) {
         attachedSensors.get(VeraCmd.GET_HUMIDITY).update(humidity.toString());
      }
   }

   @Override
   protected void updateDeviceSpecificStatus(Element element) {
      if (!StringUtils.isEmpty(element.getAttributeValue("humidity"))) {
         this.humidity = Float.parseFloat(element.getAttributeValue("humidity"));
      }
   }

}
