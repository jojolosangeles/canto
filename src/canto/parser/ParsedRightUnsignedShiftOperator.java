/* Canto Compiler and Runtime Engine
 * 
 * ParsedRightUnsignedShiftOperator.java
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
public class ParsedRightUnsignedShiftOperator extends RightUnsignedShiftOperator {
    public ParsedRightUnsignedShiftOperator(int id) {
        super();
    }

    /** Accept the visitor. **/
    public Object jjtAccept(CantoParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
