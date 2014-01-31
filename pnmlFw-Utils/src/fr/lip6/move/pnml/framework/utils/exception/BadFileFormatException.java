/**
 *  Copyright 2009 Universite Paris Ouest Nanterre & Sorbonne Universites, Univ. Paris 06 - CNRS UMR 7606 (LIP6/MoVe)
 *  All rights reserved.   This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Project leader / Initial Contributor:
 *    Lom Messan Hillah - <lom-messan.hillah@lip6.fr>
 *
 *  Contributors:
 *    ${ocontributors} - <$oemails}>
 *
 *  Mailing list:
 *    lom-messan.hillah@lip6.fr
 */
/**
 * 
 */
package fr.lip6.move.pnml.framework.utils.exception;

/**
 * @author ggiffo
 * 
 */
public class BadFileFormatException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -9106250127484515607L;

    /**
     * 
     */
    public BadFileFormatException() {
        super();
    }

    /**
     * @param arg0 .
     */
    public BadFileFormatException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0 .
     */
    public BadFileFormatException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0 .
     * @param arg1 .
     */
    public BadFileFormatException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
