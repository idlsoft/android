/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.tools.idea.tests.gui.framework.fixture.newProjectWizard;

import com.android.tools.idea.wizard.FormFactorUtils.FormFactor;
import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.core.Robot;
import org.fest.swing.driver.AbstractButtonDriver;
import org.fest.swing.driver.BasicJComboBoxCellReader;
import org.fest.swing.driver.JComboBoxDriver;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.exception.LocationUnavailableException;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ConfigureFormFactorStepFixture extends AbstractWizardStepFixture {
  @NotNull private final AbstractButtonDriver myButtonDriver;
  @NotNull private final JComboBoxDriver myComboBoxDriver;

  protected ConfigureFormFactorStepFixture(@NotNull Robot robot, @NotNull JRootPane target) {
    super(robot, target);
    myButtonDriver = new AbstractButtonDriver(robot);
    myComboBoxDriver = new JComboBoxDriver(robot);
  }

  @NotNull
  public ConfigureFormFactorStepFixture selectMinimumSdkApi(@NotNull final FormFactor formFactor, @NotNull final String api) {
    JCheckBox checkBox = robot.finder().find(target, new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
      @Override
      protected boolean isMatching(JCheckBox checkBox) {
        String text = checkBox.getText();
        // "startsWith" instead of "equals" because the UI may add "(Not installed)" at the end.
        return text != null && text.startsWith(formFactor.toString());
      }
    });
    myButtonDriver.requireEnabled(checkBox);
    myButtonDriver.select(checkBox);

    final JComboBox comboBox = robot.finder().findByName(target, formFactor.id + ".minSdk", JComboBox.class);
    int itemIndex = GuiActionRunner.execute(new GuiQuery<Integer>() {
      @Override
      protected Integer executeInEDT() throws Throwable {
        BasicJComboBoxCellReader cellReader = new BasicJComboBoxCellReader();
        int itemCount = comboBox.getItemCount();
        for (int i = 0; i < itemCount; i++) {
          String value = cellReader.valueAt(comboBox, i);
          if (value != null && value.startsWith("API " + api + ":")) {
            return i;
          }
        }
        return -1;
      }
    });
    if (itemIndex < 0) {
      throw new LocationUnavailableException("Unable to find SDK " + api + " in " + formFactor + " drop-down");
    }
    myComboBoxDriver.selectItem(comboBox, itemIndex);
    return this;
  }
}