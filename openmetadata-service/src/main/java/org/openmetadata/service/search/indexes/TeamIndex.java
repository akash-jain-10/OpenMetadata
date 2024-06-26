package org.openmetadata.service.search.indexes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openmetadata.common.utils.CommonUtil;
import org.openmetadata.schema.entity.teams.Team;
import org.openmetadata.service.Entity;
import org.openmetadata.service.search.SearchIndexUtils;
import org.openmetadata.service.search.models.SearchSuggest;
import org.openmetadata.service.util.JsonUtils;

public class TeamIndex implements SearchIndex {
  final Team team;
  final List<String> excludeFields = List.of("owns", "changeDescription");

  public TeamIndex(Team team) {
    this.team = team;
  }

  public List<SearchSuggest> getSuggest() {
    List<SearchSuggest> suggest = new ArrayList<>();
    suggest.add(SearchSuggest.builder().input(team.getName()).weight(5).build());
    suggest.add(SearchSuggest.builder().input(team.getDisplayName()).weight(10).build());
    return suggest;
  }

  public Map<String, Object> buildESDoc() {
    Map<String, Object> doc = JsonUtils.getMap(team);
    SearchIndexUtils.removeNonIndexableFields(doc, excludeFields);
    Map<String, Object> commonAttributes = getCommonAttributesMap(team, Entity.TEAM);
    doc.putAll(commonAttributes);
    doc.put("isBot", false);
    doc.put(
        "displayName",
        CommonUtil.nullOrEmpty(team.getDisplayName()) ? team.getName() : team.getDisplayName());
    return doc;
  }
}
