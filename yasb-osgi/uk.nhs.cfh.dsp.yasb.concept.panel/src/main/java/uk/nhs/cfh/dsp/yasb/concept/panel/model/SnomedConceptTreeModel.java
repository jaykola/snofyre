/**
 * Crown Copyright (C) 2008 - 2011
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.nhs.cfh.dsp.yasb.concept.panel.model;

import uk.nhs.cfh.dsp.snomed.expression.model.Expression;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * A {@link javax.swing.tree.TreeModel} that encapsulates a {@link uk.nhs.cfh.dsp.snomed.objectmodel.SnomedConcept}.
 *
 * <br>Version : @#VersionNumber#@
 * <br>Written by @author Jay Kola
 * <br>Created on Jan 5, 2010 at 9:55:23 AM
 */
public class SnomedConceptTreeModel implements TreeModel{

    /** The root concept expression. */
    private Expression rootConceptExpression;
    
    /** The listeners. */
    private List<TreeModelListener> listeners = new ArrayList<TreeModelListener>();

    /**
     * Gets the root expression.
     *
     * @return the root expression
     */
    public Expression getRootExpression() {
        return rootConceptExpression;
    }

    /**
     * Sets the root expression.
     *
     * @param rootConceptExpression the new root expression
     */
    public void setRootExpression(Expression rootConceptExpression) {
        if (rootConceptExpression != null)
        {
            this.rootConceptExpression = rootConceptExpression;
            // notify listeners
            fireTreeStructureChanged(getRootExpression());
        }
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeModel#getRoot()
     */
    public Object getRoot() {
        return rootConceptExpression;
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeModel#getChild(java.lang.Object, int)
     */
    public Object getChild(Object parent, int index) {
        Expression expression = (Expression)parent;
        List<? extends Expression> children = new ArrayList<Expression>(expression.getChildExpressions());
        return children.get(index);
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeModel#getChildCount(java.lang.Object)
     */
    public int getChildCount(Object parent) {
        return ((Expression)parent).getChildExpressions().size();
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeModel#isLeaf(java.lang.Object)
     */
    public boolean isLeaf(Object node) {
        return ((Expression)node).getChildExpressions().size() == 0;
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeModel#valueForPathChanged(javax.swing.tree.TreePath, java.lang.Object)
     */
    public void valueForPathChanged(TreePath path, Object newValue) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeModel#getIndexOfChild(java.lang.Object, java.lang.Object)
     */
    public int getIndexOfChild(Object parent, Object child) {
        Expression parentExpression = (Expression) parent;
        Expression childExpression = (Expression) child;
        List<? extends Expression> children = new ArrayList<Expression>(parentExpression.getChildExpressions());

        return children.indexOf(childExpression);
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeModel#addTreeModelListener(javax.swing.event.TreeModelListener)
     */
    public void addTreeModelListener(TreeModelListener l) {
        if(l != null)
        {
            listeners.add(l);
        }
        else
        {
            throw new IllegalArgumentException("Listener passed can not be null.");
        }
    }

    /* (non-Javadoc)
     * @see javax.swing.tree.TreeModel#removeTreeModelListener(javax.swing.event.TreeModelListener)
     */
    public void removeTreeModelListener(TreeModelListener l) {
        if(l != null)
        {
            listeners.remove(l);
        }
        else
        {
            throw new IllegalArgumentException("Listener passed can not be null.");
        }
    }

    /**
     * Fire tree structure changed.
     *
     * @param newRootExpression the new root expression
     */
    protected void fireTreeStructureChanged(Expression newRootExpression){

        // get model event
        TreeModelEvent e = new TreeModelEvent(this, new Object[] {newRootExpression});
        for(TreeModelListener listener : listeners)
        {
            listener.treeStructureChanged(e);
        }
    }
}
