/*
 * Classname: MapAdapter
 * 
 * Version 1.0
 *
 * Copyright (C) 2014 Chris
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package model.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * This class allows for Maps to be converted into objects that can be written
 * to XML files and allows data to be entered into the Maps when reading from
 * XML files
 *
 * @author Chris
 */
public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedMap, Map<String, Object>> {

    /**
     * Class that holds a list used for writing to XML files
     */
    public static class AdaptedMap {

        public List<Entry> entry = new ArrayList<Entry>();
    }

    /**
     * Class that sets the structure for items to be added to the entry List
     */
    public static class Entry {

        public String key;
        public Object value;
    }

    @Override
    public Map<String, Object> unmarshal(AdaptedMap adaptedMap) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        for (Entry entry : adaptedMap.entry) {
            map.put(entry.key, entry.value);

        }
        return map;
    }

    @Override
    public AdaptedMap marshal(Map<String, Object> map) throws Exception {
        AdaptedMap adaptedMap = new AdaptedMap();
        for (Map.Entry<String, Object> mapEntry : map.entrySet()) {
            Entry entry = new Entry();
            entry.key = mapEntry.getKey();
            entry.value = mapEntry.getValue();
            adaptedMap.entry.add(entry);
        }
        return adaptedMap;
    }

}
