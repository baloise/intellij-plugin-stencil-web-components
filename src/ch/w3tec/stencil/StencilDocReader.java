package ch.w3tec.stencil;

import ch.w3tec.stencil.dto.StencilDoc;
import com.google.gson.Gson;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StencilDocReader {

    public static StencilDocReader INSTANCE = new StencilDocReader();

    public StencilDoc stencilDoc;

    private StencilDocReader() {
        Optional<StencilDoc> doc = this.deserialize();
        doc.ifPresent(value -> this.stencilDoc = value);
    }

    private List<Path> getAllStencilDocs(String projectBasePath) throws IOException {
        Path path = Paths.get(projectBasePath);
        return Files.walk(path)
                .filter(Files::isRegularFile)
                .filter(file -> file.toAbsolutePath().toString().contains("dist/docs.json"))
                .collect(Collectors.toList());
    }

    private Optional<StencilDoc> deserialize() {
        Project project = ProjectManager.getInstance().getOpenProjects()[0];

        if (project != null && project.getBasePath() != null) {
            try {
                List<Path> allStencilDocs = getAllStencilDocs(project.getBasePath());
                // OPTIMIZE: be able to read multiple files
                if (allStencilDocs.size() > 0) {
                    Gson gson = new Gson();
                    // OPTIMIZE: check for docs.json files that they actually are from stencil
                    String json = String.join("", Files.readAllLines(allStencilDocs.iterator().next()));
                    return Optional.of(gson.fromJson(json, StencilDoc.class));
                }
            } catch (Exception e) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

}
