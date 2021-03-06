/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kasabi.labs.vocabularies;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

public class GEONAMES {

	public final static String NAMESPACE = "http://www.geonames.org/ontology" + "#" ;

	public static String getURI() { return NAMESPACE; }
    protected final static Resource resource( String local ) { return ResourceFactory.createResource( NAMESPACE + local ); }
    protected final static Property property( String local ) { return ResourceFactory.createProperty( NAMESPACE + local ); }
   
    public final static Resource A_ADM1 = resource( "A.ADM1" );
    public final static Resource A_ADM2 = resource( "A.ADM2" );
    public final static Resource A_ADM3 = resource( "A.ADM3" );
    public final static Resource A_ADM4 = resource( "A.ADM4" );

    public final static Property featureCode = property( "featureCode" );
    
}
