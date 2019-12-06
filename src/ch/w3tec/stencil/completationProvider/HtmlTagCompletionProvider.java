package ch.w3tec.stencil.completationProvider;

import ch.w3tec.stencil.StencilDocReader;
import ch.w3tec.stencil.dto.StencilMergedDoc;
import ch.w3tec.stencil.util.CompletionTypeUtil;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static ch.w3tec.stencil.completationProvider.IconUtil.addIcon;

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
                        completionResultSet.addElement(addIcon(lookupElement));
                    });
        }

    }
}
