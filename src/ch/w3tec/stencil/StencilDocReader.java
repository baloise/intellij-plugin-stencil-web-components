package ch.w3tec.stencil;

import ch.w3tec.stencil.dto.StencilDoc;
import com.google.gson.Gson;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.fileEditor.impl.LoadTextUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FilenameIndex;

import java.util.Collection;
import java.util.Optional;

public class StencilDocReader {

    public static StencilDocReader INSTANCE = new StencilDocReader();

    public StencilDoc stencilDoc;

    private StencilDocReader() {
        Optional<StencilDoc> doc = this.deserialize();
        doc.ifPresent(value -> this.stencilDoc = value);
    }

    private Optional<StencilDoc> deserialize() {
        DataContext dataContext = DataManager.getInstance().getDataContext();
        Project project = (Project) dataContext.getData(DataConstants.PROJECT);

        if (project != null) {
            Collection<VirtualFile> files = FilenameIndex.getAllFilesByExt(project, "json");
            Optional<VirtualFile> file = files.stream()
                    .filter(virtualFile -> virtualFile != null
                            && virtualFile.getCanonicalPath() != null
                            && virtualFile.getCanonicalPath().contains("bal-ui-library")
                            && virtualFile.getCanonicalPath().endsWith("dist/package.json"))
                    .findFirst();

            if (file.isPresent()) {
                Gson gson = new Gson();
                return Optional.of(gson.fromJson(LoadTextUtil.loadText(file.get()).toString(), StencilDoc.class));
            }

        }

        return Optional.empty();

    }

}
