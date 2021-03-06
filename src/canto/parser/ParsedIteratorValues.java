/* Canto Compiler and Runtime Engine
 * 
 * ParsedIteratorValues.java
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
 * @version $Revision: 1.6 $
 */
public class ParsedIteratorValues extends ForStatement.IteratorValues implements Initializable {

    private boolean optional = false;
    private boolean hasIn = false;
    private boolean hasFrom = false;
    private boolean hasTo = false;
    private boolean hasThrough = false;
    private boolean hasBy = false;
    private boolean hasWhere = false;
    private boolean hasUntil = false;

    public ParsedIteratorValues(int id) {
        super();
    }

    /** Accept the visitor. **/
    public Object jjtAccept(CantoParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public void init() {
        DefParameter defParam = null;
        Construction in = null;
        ValueSource from = null;
        int ix = 0;
        if (hasIn || hasFrom) {
            defParam = (DefParameter) getChild(0);
            in = (hasIn ? (Construction) getChild(1) : null);
            from = (hasFrom ? (ValueSource) getChild(1) : null);
            ix = 2;
        }
        ValueSource to = (hasTo ? (ValueSource) getChild(ix++) : null);
        ValueSource through = (hasThrough ? (ValueSource) getChild(ix++) : null);
        ValueSource by = (hasBy ? (ValueSource) getChild(ix++) : null);
        ValueSource where = (hasWhere ? (ValueSource) getChild(ix++) : null);
        ValueSource until = (hasUntil ? (ValueSource) getChild(ix++) : null);
        set(defParam, in, from, to, through, by, where, until, optional);
    }

    void setIn(boolean in) {
        hasIn = in;
    }

    void setFrom(boolean from) {
        hasFrom = from;
    }

    void setTo(boolean to) {
        hasTo = to;
    }

    void setThrough(boolean through) {
        hasThrough = through;
    }

    void setBy(boolean by) {
        hasBy = by;
    }

    void setWhere(boolean where) {
        hasWhere = where;
    }

    void setUntil(boolean until) {
        hasUntil = until;
    }

    void setOptional(boolean optional) {
        this.optional = optional;
    }
}
