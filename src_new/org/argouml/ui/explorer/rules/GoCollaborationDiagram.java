// $Id$
// Copyright (c) 1996-2004 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.ui.explorer.rules;

import java.util.Collection;
import java.util.Set;
import java.util.Vector;

import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.ModelFacade;
import org.argouml.uml.diagram.collaboration.ui.UMLCollaborationDiagram;

public class GoCollaborationDiagram extends AbstractPerspectiveRule {

    public String getRuleName() {
        return "Collaboration->Diagram";
    }

    public Collection getChildren(Object parent) {
        if (!ModelFacade.isACollaboration(parent))
            return null;

        Project p = ProjectManager.getManager().getCurrentProject();
        if (p == null)
            return null;

        Vector res = new Vector();
        Vector diagrams = p.getDiagrams();
        if (diagrams == null)
            return null;
        java.util.Enumeration elems = diagrams.elements();
        while (elems.hasMoreElements()) {
            Object d = elems.nextElement();
            if (d instanceof UMLCollaborationDiagram
                && ((UMLCollaborationDiagram)d).getNamespace() == parent)
                res.addElement(d);
        }
        return res;
    }

    public Set getDependencies(Object parent) {
        // TODO: What?
	return null;
    }
}
