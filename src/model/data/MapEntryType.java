/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.data;

import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlAttribute;
/**
 *
 * @author Shadow
 */
public class MapEntryType {
   @XmlAttribute
   public String key; 

   @XmlValue
   public Object value;
}
