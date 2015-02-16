/**
 *  Copyright 2009-2015 Université Paris Ouest and Sorbonne Universités,
 * 							Univ. Paris 06 - CNRS UMR 7606 (LIP6)
 *
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
 * (C) Sorbonne Universités, UPMC Univ Paris 06, UMR CNRS 7606 (LIP6/MoVe)
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *    Lom HILLAH (LIP6) - Initial models and implementation
 *    Rachid Alahyane (UPMC) - Infrastructure and continuous integration
 *    Bastien Bouzerau (UPMC) - Architecture 
 *    Guillaume Giffo (UPMC) - Code generation refactoring, High-level API
 *
 * $Id ggiffo, Tue Dec 23 11:30:49 CET 2014$
 */
package fr.lip6.move.pnml.pthlpng.hlcorestructure.hlapi;

import fr.lip6.move.pnml.pthlpng.booleans.And;
import fr.lip6.move.pnml.pthlpng.booleans.Bool;
import fr.lip6.move.pnml.pthlpng.booleans.BooleanConstant;
import fr.lip6.move.pnml.pthlpng.booleans.Equality;
import fr.lip6.move.pnml.pthlpng.booleans.Imply;
import fr.lip6.move.pnml.pthlpng.booleans.Inequality;
import fr.lip6.move.pnml.pthlpng.booleans.Not;
import fr.lip6.move.pnml.pthlpng.booleans.Or;

import fr.lip6.move.pnml.pthlpng.booleans.impl.BooleansFactoryImpl;

import fr.lip6.move.pnml.pthlpng.dots.Dot;
import fr.lip6.move.pnml.pthlpng.dots.DotConstant;

import fr.lip6.move.pnml.pthlpng.dots.impl.DotsFactoryImpl;

import fr.lip6.move.pnml.pthlpng.hlcorestructure.Annotation;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.AnnotationGraphics;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.AnyObject;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Arc;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.ArcGraphics;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2Color;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2FontFamily;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2FontSize;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2FontStyle;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.CSS2FontWeight;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Condition;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Declaration;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Dimension;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Fill;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Font;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.FontAlign;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.FontDecoration;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Gradient;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.HLAnnotation;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.HLMarking;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Label;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Line;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.LineShape;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.LineStyle;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Name;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Node;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.NodeGraphics;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Offset;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PNType;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Page;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PetriNet;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PetriNetDoc;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Place;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.PnObject;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Position;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.RefPlace;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.RefTransition;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.ToolInfo;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.Type;

import fr.lip6.move.pnml.pthlpng.hlcorestructure.impl.HlcorestructureFactoryImpl;

import fr.lip6.move.pnml.pthlpng.multisets.All;
import fr.lip6.move.pnml.pthlpng.multisets.Empty;

import fr.lip6.move.pnml.pthlpng.multisets.impl.MultisetsFactoryImpl;

import fr.lip6.move.pnml.pthlpng.partitions.Partition;
import fr.lip6.move.pnml.pthlpng.partitions.PartitionElement;

import fr.lip6.move.pnml.pthlpng.partitions.impl.PartitionsFactoryImpl;

import fr.lip6.move.pnml.pthlpng.terms.MultisetSort;
import fr.lip6.move.pnml.pthlpng.terms.NamedOperator;
import fr.lip6.move.pnml.pthlpng.terms.NamedSort;
import fr.lip6.move.pnml.pthlpng.terms.Operator;
import fr.lip6.move.pnml.pthlpng.terms.ProductSort;
import fr.lip6.move.pnml.pthlpng.terms.Sort;
import fr.lip6.move.pnml.pthlpng.terms.Term;
import fr.lip6.move.pnml.pthlpng.terms.VariableDecl;

import fr.lip6.move.pnml.pthlpng.terms.impl.TermsFactoryImpl;

import java.math.BigDecimal;

import java.net.URI;

import java.util.List;

import  fr.lip6.move.pnml.framework.hlapi.*;
import fr.lip6.move.pnml.pthlpng.booleans.hlapi.*;
import fr.lip6.move.pnml.pthlpng.dots.hlapi.*;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.hlapi.*;
import fr.lip6.move.pnml.pthlpng.multisets.hlapi.*;
import fr.lip6.move.pnml.pthlpng.partitions.hlapi.*;
import fr.lip6.move.pnml.pthlpng.terms.hlapi.*;

import java.util.ArrayList;
import java.util.List;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import org.apache.axiom.om.*;
import fr.lip6.move.pnml.framework.utils.IdRefLinker;
import org.eclipse.emf.common.util.DiagnosticChain;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.*;
import fr.lip6.move.pnml.pthlpng.hlcorestructure.impl.*;
import fr.lip6.move.pnml.framework.utils.exception.InnerBuildException;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.framework.utils.exception.VoidRepositoryException;
import fr.lip6.move.pnml.framework.utils.exception.OtherException;
import fr.lip6.move.pnml.framework.utils.IdRepository;
import fr.lip6.move.pnml.framework.utils.ModelRepository;


public class PlaceHLAPI implements HLAPIClass,PnObjectHLAPI,NodeHLAPI,PlaceNodeHLAPI{

	/**
	 * The contained LLAPI element.
	 */
	private Place item;

	/**
	 * this constructor allows you to set all 'settable' values
	 * excepted container.
	 */
	
	public PlaceHLAPI(
		 java.lang.String id
	
		, NameHLAPI name
	
		, NodeGraphicsHLAPI nodegraphics
	
		, TypeHLAPI type
	
		, HLMarkingHLAPI hlinitialMarking
	) throws InvalidIDException ,VoidRepositoryException {//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createPlace();}
	
 		
			if(id!=null){
			
				item.setId(ModelRepository.getInstance().getCurrentIdRepository().checkId(id, this));
			}
		
	
 		
 		if(name!=null)
			item.setName((Name)name.getContainedItem());
		
	
 		
 		if(nodegraphics!=null)
			item.setNodegraphics((NodeGraphics)nodegraphics.getContainedItem());
		
	
 		
 		if(type!=null)
			item.setType((Type)type.getContainedItem());
		
	
 		
 		if(hlinitialMarking!=null)
			item.setHlinitialMarking((HLMarking)hlinitialMarking.getContainedItem());
		
	
	}

	/**
	 * this constructor allows you to set all 'settable' values, including container if any.
	 */
	
	public PlaceHLAPI(
		 java.lang.String id
	
		, NameHLAPI name
	
		, NodeGraphicsHLAPI nodegraphics
	
		, TypeHLAPI type
	
		, HLMarkingHLAPI hlinitialMarking
	
		, PageHLAPI containerPage
	) throws InvalidIDException ,VoidRepositoryException {//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createPlace();}
	
 		
			if(id!=null){
			
				item.setId(ModelRepository.getInstance().getCurrentIdRepository().checkId(id, this));
			}
		
	
 		
 		if(name!=null)
			item.setName((Name)name.getContainedItem());
		
	
 		
 		if(nodegraphics!=null)
			item.setNodegraphics((NodeGraphics)nodegraphics.getContainedItem());
		
	
 		
 		if(type!=null)
			item.setType((Type)type.getContainedItem());
		
	
 		
 		if(hlinitialMarking!=null)
			item.setHlinitialMarking((HLMarking)hlinitialMarking.getContainedItem());
		
	
 		
 		if(containerPage!=null)
			item.setContainerPage((Page)containerPage.getContainedItem());
		
	
	}


	/**
    * This constructor give access to required stuff only (not container if any)
    */
	public PlaceHLAPI(
		 java.lang.String id
	) throws InvalidIDException ,VoidRepositoryException {//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createPlace();}
	
 		
			if(id!=null){
			
				item.setId(ModelRepository.getInstance().getCurrentIdRepository().checkId(id, this));
			}
		
	
	}


	
	/**
    * This constructor give access to required stuff only (and container)
    */
	public PlaceHLAPI(
		 java.lang.String id
	
		, PageHLAPI containerPage
	) throws InvalidIDException ,VoidRepositoryException {//BEGIN CONSTRUCTOR BODY
		HlcorestructureFactory fact = HlcorestructureFactoryImpl.eINSTANCE;
		synchronized(fact){item = fact.createPlace();}
	
 		
			if(id!=null){
			
				item.setId(ModelRepository.getInstance().getCurrentIdRepository().checkId(id, this));
			}
		
	
 		
 		if(containerPage!=null)
			item.setContainerPage((Page)containerPage.getContainedItem());
		
	
	}
	

	/**
	 * This constructor encapsulate a low level API object in HLAPI.
	 */
	public PlaceHLAPI(Place lowLevelAPI){
		item = lowLevelAPI;
	}

	// access to low level API
	/**
	 * Return encapsulated object
	 */
	public Place getContainedItem(){
		return item;
	}

	//getters giving LLAPI object
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public String getId(){
		return item.getId();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public Name getName(){
		return item.getName();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public List<ToolInfo> getToolspecifics(){
		return item.getToolspecifics();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public Page getContainerPage(){
		return item.getContainerPage();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public List<Arc> getInArcs(){
		return item.getInArcs();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public List<Arc> getOutArcs(){
		return item.getOutArcs();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public NodeGraphics getNodegraphics(){
		return item.getNodegraphics();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public List<RefPlace> getReferencingPlaces(){
		return item.getReferencingPlaces();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public Type getType(){
		return item.getType();
	}
	
	/**
	 * Return the encapsulate Low Level API object.
	 */
	public HLMarking getHlinitialMarking(){
		return item.getHlinitialMarking();
	}
	

	//getters giving HLAPI object
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public NameHLAPI getNameHLAPI(){
			if(item.getName() == null) return null;
			return new NameHLAPI(item.getName());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate all elements of the selected sublist.
		 * WARNING : this can creates a lot of new object in memory.
		 */
		
		public java.util.List<ToolInfoHLAPI> getToolspecificsHLAPI(){
			java.util.List<ToolInfoHLAPI> retour = new ArrayList<ToolInfoHLAPI>();
			for (ToolInfo elemnt : getToolspecifics()) {
				retour.add(new ToolInfoHLAPI(elemnt));
			}
			return retour;
		}
	
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public PageHLAPI getContainerPageHLAPI(){
			if(item.getContainerPage() == null) return null;
			return new PageHLAPI(item.getContainerPage());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate all elements of the selected sublist.
		 * WARNING : this can creates a lot of new object in memory.
		 */
		
		public java.util.List<ArcHLAPI> getInArcsHLAPI(){
			java.util.List<ArcHLAPI> retour = new ArrayList<ArcHLAPI>();
			for (Arc elemnt : getInArcs()) {
				retour.add(new ArcHLAPI(elemnt));
			}
			return retour;
		}
	
	
	
	
	
		/**
		 * This accessor automatically encapsulate all elements of the selected sublist.
		 * WARNING : this can creates a lot of new object in memory.
		 */
		
		public java.util.List<ArcHLAPI> getOutArcsHLAPI(){
			java.util.List<ArcHLAPI> retour = new ArrayList<ArcHLAPI>();
			for (Arc elemnt : getOutArcs()) {
				retour.add(new ArcHLAPI(elemnt));
			}
			return retour;
		}
	
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public NodeGraphicsHLAPI getNodegraphicsHLAPI(){
			if(item.getNodegraphics() == null) return null;
			return new NodeGraphicsHLAPI(item.getNodegraphics());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate all elements of the selected sublist.
		 * WARNING : this can creates a lot of new object in memory.
		 */
		
		public java.util.List<RefPlaceHLAPI> getReferencingPlacesHLAPI(){
			java.util.List<RefPlaceHLAPI> retour = new ArrayList<RefPlaceHLAPI>();
			for (RefPlace elemnt : getReferencingPlaces()) {
				retour.add(new RefPlaceHLAPI(elemnt));
			}
			return retour;
		}
	
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public TypeHLAPI getTypeHLAPI(){
			if(item.getType() == null) return null;
			return new TypeHLAPI(item.getType());
		}
		
	
	
	
	
		/**
		 * This accessor automatically encapsulate an element of the current object.
		 * WARNING : this creates a new object in memory.
		 * @return : null if the element is null
		 */
		
		public HLMarkingHLAPI getHlinitialMarkingHLAPI(){
			if(item.getHlinitialMarking() == null) return null;
			return new HLMarkingHLAPI(item.getHlinitialMarking());
		}
		
	
	

	//Special getter for list of generics object, return only one object type.
	
	
	
	
	
	
	
	
	
	

	//setters (including container setter if aviable)
	
	
	/**
	 * set Id
	 */
	public void setIdHLAPI(
	
	java.lang.String elem) throws InvalidIDException ,VoidRepositoryException   {
	
	
		if(elem!=null){
		
			try{
			item.setId(ModelRepository.getInstance().getCurrentIdRepository().changeId(this, elem));
			}catch (OtherException e){
			ModelRepository.getInstance().getCurrentIdRepository().checkId(elem, this);
			}
		}
	
	}
	
	/**
	 * set Name
	 */
	public void setNameHLAPI(
	
	NameHLAPI elem){
	
	
 		if(elem!=null)
			item.setName((Name)elem.getContainedItem());
	
	}
	
	/**
	 * set Nodegraphics
	 */
	public void setNodegraphicsHLAPI(
	
	NodeGraphicsHLAPI elem){
	
	
 		if(elem!=null)
			item.setNodegraphics((NodeGraphics)elem.getContainedItem());
	
	}
	
	/**
	 * set Type
	 */
	public void setTypeHLAPI(
	
	TypeHLAPI elem){
	
	
 		if(elem!=null)
			item.setType((Type)elem.getContainedItem());
	
	}
	
	/**
	 * set HlinitialMarking
	 */
	public void setHlinitialMarkingHLAPI(
	
	HLMarkingHLAPI elem){
	
	
 		if(elem!=null)
			item.setHlinitialMarking((HLMarking)elem.getContainedItem());
	
	}
	
	/**
	 * set ContainerPage
	 */
	public void setContainerPageHLAPI(
	
	PageHLAPI elem){
	
	
 		if(elem!=null)
			item.setContainerPage((Page)elem.getContainedItem());
	
	}
	

	//setters/remover for lists.
	
	
	public void addToolspecificsHLAPI(ToolInfoHLAPI unit){
	
		item.getToolspecifics().add((ToolInfo)unit.getContainedItem());
	}

	public void removeToolspecificsHLAPI(ToolInfoHLAPI unit){
		item.getToolspecifics().remove((ToolInfo)unit.getContainedItem());
	}
	

	//equals method
	public boolean equals(PlaceHLAPI item){
		return item.getContainedItem().equals(getContainedItem());
	}

	//PNML
	
	/**
	 * Returns the PNML xml tree for this object.
	 */
	public String toPNML(){
		return item.toPNML();
	}
	
	/**
	 * Writes the PNML XML tree of this object into file channel.
	 */
	public void toPNML(FileChannel fc){
		 item.toPNML(fc);
	}

	/**
	 * creates an object from the xml nodes.(symetric work of toPNML)
	 */
	public void fromPNML(OMElement subRoot,IdRefLinker idr) throws InnerBuildException, InvalidIDException, VoidRepositoryException{
		item.fromPNML(subRoot,idr);
	}
	

	public boolean validateOCL(DiagnosticChain diagnostics){
		return item.validateOCL(diagnostics);
	}

}