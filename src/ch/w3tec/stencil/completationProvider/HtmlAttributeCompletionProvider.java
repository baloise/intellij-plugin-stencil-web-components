package ch.w3tec.stencil.completationProvider;

import ch.w3tec.stencil.StencilDocReader;
import ch.w3tec.stencil.dto.StencilMergedDoc;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.html.HtmlTagImpl;
import com.intellij.psi.impl.source.xml.XmlAttributeImpl;
import com.intellij.psi.impl.source.xml.XmlAttributeReference;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class HtmlAttributeCompletionProvider extends CompletionProvider<CompletionParameters> {

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  @NotNull ProcessingContext processingContext,
                                  @NotNull CompletionResultSet completionResultSet) {

        StencilMergedDoc stencilDoc = StencilDocReader.INSTANCE.stencilDoc;
        PsiReference reference = parameters.getPosition().getContainingFile().findReferenceAt(parameters.getOffset());
        if (reference != null) {
            String name = ((XmlAttributeReference) reference).getElement().getParent().getName();
            stencilDoc.getComponents().stream()
                    .filter(stencilDocComponent -> stencilDocComponent.tag.equals(name))
                    .forEach(stencilDocComponent -> {
                        stencilDocComponent.props
                                .forEach(stencilDocComponentProp -> {
                                    completionResultSet.addElement(LookupElementBuilder.create(stencilDocComponentProp.name));
                                });
                    });
        } else {
            if (parameters.getPosition().getParent() instanceof XmlAttributeValue) {
                XmlAttributeImpl xmlAttribute = (XmlAttributeImpl) parameters.getPosition().getParent().getParent();
                HtmlTagImpl htmlTag = (HtmlTagImpl) xmlAttribute.getParent();
                stencilDoc.getComponents().stream()
                        .filter(stencilDocComponent -> stencilDocComponent.tag.equals(htmlTag.getName()))
                        .forEach(stencilDocComponent -> {
                            stencilDocComponent.props.stream()
                                    .filter(stencilDocComponentProp -> stencilDocComponentProp.name.equals(xmlAttribute.getName()))
                                    .forEach(stencilDocComponentProp -> {
                                        stencilDocComponentProp.values.stream()
                                                .filter(stencilDocComponentPropsValues -> stencilDocComponentPropsValues.value != null)
                                                .forEach(stencilDocComponentPropsValues -> {
                                                    completionResultSet.addElement(LookupElementBuilder.create(stencilDocComponentPropsValues.value));

                                                });
                                    });
                        });
            }
        }

    }

}
