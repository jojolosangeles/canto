/* Canto Compiler and Runtime Engine
 * 
 * ParsedAnonymousTable.java
 *
 * Copyright (c) 2018 by cantolang.org
 * All rights reserved.
 */

package canto.parser;

import java.util.*;

import canto.lang.*;

/**
 * Based on code generated by jjtree.
 *
 * @author Michael St. Hippolyte
 * @version $Revision: 1.8 $
 */
public class ParsedAnonymousTable extends CollectionDefinition implements Initializable {

    public ParsedAnonymousTable(int id) {
        super();
    }

    /** Accept the visitor. **/
    public Object jjtAccept(CantoParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public void init() {
        int len = (children == null ? 0 : children.length);
        // TableDefinition expects the contents to be in an ArgumentList; this 
        // particular ArgumentList constructor accepts any kind of node but
        // if it isn't a Construction, it gets turned into one.
        ArgumentList contents = (len > 0 ? new ArgumentList(children) : null);
        NameNode name = new NameNode(Name.ANONYMOUS);
        Dim dim = new Dim(Dim.TYPE.DEFINITE, len);
        dim.setTable(true);
        List<Dim> dims = new SingleItemList<Dim>(dim);
        setDims(dims);
        setTable(true);
        init(null, name, contents);
    }
}
