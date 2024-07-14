/*
 *  Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com)
 *
 *  WSO2 LLC. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package io.ballerina.wsdl.core.generator.util;

import io.ballerina.compiler.syntax.tree.AbstractNodeFactory;
import io.ballerina.compiler.syntax.tree.IdentifierToken;
import io.ballerina.compiler.syntax.tree.ImportDeclarationNode;
import io.ballerina.compiler.syntax.tree.ImportOrgNameNode;
import io.ballerina.compiler.syntax.tree.NodeFactory;
import io.ballerina.compiler.syntax.tree.SeparatedNodeList;
import io.ballerina.compiler.syntax.tree.SyntaxKind;
import io.ballerina.compiler.syntax.tree.Token;

/**
 * Provides utility functions for generating components of the abstract syntax tree used in language implementations.
 *
 * @since 0.1.0
 */
public class GeneratorUtils {

    public static ImportDeclarationNode getImportDeclarationNode(String orgName, String moduleName) {
        Token importKeyword = NodeFactory.createToken(SyntaxKind.IMPORT_KEYWORD);
        Token orgNameToken = AbstractNodeFactory.createIdentifierToken(orgName);
        Token slashToken = NodeFactory.createToken(SyntaxKind.SLASH_TOKEN);
        ImportOrgNameNode importOrgNameNode = NodeFactory.createImportOrgNameNode(orgNameToken, slashToken);
        Token moduleNameToken = AbstractNodeFactory.createIdentifierToken(moduleName);
        SeparatedNodeList<IdentifierToken> moduleNodeList = AbstractNodeFactory.createSeparatedNodeList(
                moduleNameToken);
        Token semicolon = NodeFactory.createToken(SyntaxKind.SEMICOLON_TOKEN);

        return NodeFactory.createImportDeclarationNode(importKeyword, importOrgNameNode,
                moduleNodeList, null, semicolon);
    }
}