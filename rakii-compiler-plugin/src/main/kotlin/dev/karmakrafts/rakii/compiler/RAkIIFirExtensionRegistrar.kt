/*
 * Copyright 2025 Karma Krafts & associates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.karmakrafts.rakii.compiler

import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.fir.extensions.FirDeclarationGenerationExtension
import org.jetbrains.kotlin.fir.extensions.FirExtensionRegistrar

internal class RAkIIFirExtensionRegistrar(
    private val messageCollector: MessageCollector
) : FirExtensionRegistrar() {
    override fun ExtensionRegistrarContext.configurePlugin() {
        messageCollector.report(CompilerMessageSeverity.INFO, "Configuring RAkII FIR generation extension")
        +FirDeclarationGenerationExtension.Factory { RAkIIDropGenerationExtension(it, messageCollector) }
    }
}