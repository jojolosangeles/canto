/* Canto Compiler and Runtime Engine
 * 
 * ParsedNameWithArguments.java
 *
 * Copyright (c) 2018 by cantolang.org
 * All rights reserved.
 */

package canto.parser;

import canto.lang.*;

/**
 * Based on code generated by jjtree.
 *
 * @author Michael St. Hippolyte
 * @version $Revision: 1.3 $
 */
public class ParsedNameWithArguments extends NameWithArgs {
    public ParsedNameWithArguments(int id) {
        super();
    }

    /** Accept the visitor. **/
    public Object jjtAccept(CantoParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
