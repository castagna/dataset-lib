/*
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

package com.kasabi.labs.arq;

import java.util.List;

import com.hp.hpl.jena.query.QueryBuildException;
import com.hp.hpl.jena.sparql.expr.ExprEvalException;
import com.hp.hpl.jena.sparql.expr.ExprList;
import com.hp.hpl.jena.sparql.expr.NodeValue;
import com.hp.hpl.jena.sparql.function.FunctionBase;
import com.hp.hpl.jena.sparql.util.Utils;

public class replace extends FunctionBase {

	public replace() { 
		super() ; 
	}

    @Override 
    public void checkBuild(String uri, ExprList args) {
        if ( args.size() != 3 ) 
        	throw new QueryBuildException("Function '"+Utils.className(this)+"' takes three arguments") ;
    }

    @Override
    public NodeValue exec(List<NodeValue> args) {
        if ( args.size() > 3 )
        	throw new ExprEvalException("replace: Wrong number of arguments: "+args.size()+" : [wanted 3]") ;
        
        NodeValue v1 = args.get(0) ;
        NodeValue v2 = args.get(1) ;
        NodeValue v3 = args.get(2) ;
        
        return javaReplace(v1, v2, v3) ;
    }
    
    private static NodeValue javaReplace(NodeValue nvString, NodeValue nvRegex, NodeValue nvReplacement)
    {
        try {
            String string = nvString.getString() ;
            String regex = nvRegex.getString() ;
            String replacement = nvReplacement.getString() ;
            
            return NodeValue.makeString(string.replaceAll(regex, replacement)) ;
        } catch (IndexOutOfBoundsException ex) {
            throw new ExprEvalException("IndexOutOfBounds", ex) ;
        }
    }
        
}
