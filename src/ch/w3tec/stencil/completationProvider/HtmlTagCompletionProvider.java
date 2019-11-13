package ch.w3tec.stencil.completationProvider;

import ch.w3tec.stencil.dto.StencilDoc;
import ch.w3tec.stencil.StencilDocReader;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.util.ProcessingContext;
import org.apache.xmlbeans.XmlToken;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;

public class HtmlTagCompletionProvider extends CompletionProvider<CompletionParameters> {

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  @NotNull ProcessingContext processingContext,
                                  @NotNull CompletionResultSet completionResultSet) {


        if (parameters.getPosition() instanceof XmlToken) {
            try {
                StencilDoc stencilDoc = StencilDocReader.deserialize();
                stencilDoc.components
                        .forEach(stencilDocComponent -> {
                            completionResultSet.addElement(LookupElementBuilder.create(stencilDocComponent.tag));
                        });

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
