/*******************************************************************************
 * Copyright (c) 2013 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.ui.databinding;

import java.text.MessageFormat;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import org.eclipse.core.databinding.property.value.IValueProperty;

/**
 * Utility to setup a {@link TableView} with {@link TableColumn}
 */
public class TableUtil {
	/**
	 * Setup a table column using the property for the cell text
	 * 
	 * @param column
	 *            the column
	 * @param property
	 *            the property
	 * @see PropertyTableCellFactory#textFactory(IValueProperty)
	 */
	public static <S> void setupColumn(TableColumn<S, S> column,
			IValueProperty property) {
		column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<S, S>, ObservableValue<S>>() {

			@Override
			public ObservableValue<S> call(CellDataFeatures<S, S> param) {
				return new SimpleObjectProperty<S>(param.getValue());
			}
		});
		column.setCellFactory(PropertyTableCellFactory
				.<S, S> textFactory(property));
	}

	/**
	 * Setup a table column using the properties and the template for the cell
	 * text using {@link MessageFormat}
	 * 
	 * @param column
	 *            the column
	 * @param template
	 *            the template
	 * @param property
	 *            the properties
	 * @see PropertyTableCellFactory#textFactory(String, IValueProperty...)
	 */
	public static <S> void setupColumn(TableColumn<S, S> column,
			String template, IValueProperty... property) {
		column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<S, S>, ObservableValue<S>>() {

			@Override
			public ObservableValue<S> call(CellDataFeatures<S, S> param) {
				return new SimpleObjectProperty<S>(param.getValue());
			}
		});
		column.setCellFactory(PropertyTableCellFactory.<S, S> textFactory(
				template, property));
	}
}
