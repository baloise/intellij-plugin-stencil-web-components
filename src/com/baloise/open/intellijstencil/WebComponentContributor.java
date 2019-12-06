package com.baloise.open.intellijstencil;

import com.baloise.open.intellijstencil.completationProvider.HtmlAttributeCompletionProvider;
import com.baloise.open.intellijstencil.completationProvider.HtmlTagCompletionProvider;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.XmlPatterns;

import static com.intellij.patterns.PsiJavaPatterns.psiElement;

public class WebComponentContributor extends CompletionContributor {

    public WebComponentContributor() {

        extend(CompletionType.BASIC,
                psiElement().inside(XmlPatterns.xmlTag()),
                new HtmlTagCompletionProvider()
        );

        extend(CompletionType.BASIC,
                psiElement().inside(XmlPatterns.xmlAttribute()),
                new HtmlAttributeCompletionProvider()
        );

    }

}
