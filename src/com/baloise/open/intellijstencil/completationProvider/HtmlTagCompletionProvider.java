package com.baloise.open.intellijstencil.completationProvider;

import com.baloise.open.intellijstencil.StencilDocReader;
import com.baloise.open.intellijstencil.dto.StencilMergedDoc;
import com.baloise.open.intellijstencil.util.CompletionTypeUtil;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class HtmlTagCompletionProvider extends CompletionProvider<CompletionParameters> {

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  @NotNull ProcessingContext processingContext,
                                  @NotNull CompletionResultSet completionResultSet) {


        if (CompletionTypeUtil.isTag(parameters)) {
            StencilMergedDoc stencilDoc = StencilDocReader.INSTANCE.stencilDoc;
            stencilDoc.getComponents()
                    .forEach(stencilDocComponent -> {
                        LookupElementBuilder lookupElement = LookupElementBuilder.create(stencilDocComponent.tag);
                        completionResultSet.addElement(IconUtil.addIcon(lookupElement));
                    });
        }

    }
}
