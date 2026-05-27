package com.mycompany.proyecto_eda;

public class Juego {
    private String id;
    private String slug;
    private String name;
    private Integer metacritic;
    private int playtime;

    public Juego() {}

    public Juego(String id, String slug, String name, Integer metacritic, int playtime) {
        this.id = id;
        this.slug = slug;
        this.name = name;
        this.metacritic = metacritic;
        this.playtime = playtime;
    }

    public String getId() { return id; }
    public String getSlug() { return slug; }
    public String getName() { return name; }
    public Integer getMetacritic() { return metacritic; }
    public int getPlaytime() { return playtime; }

    public void setId(String id) { this.id = id; }
    public void setSlug(String slug) { this.slug = slug; }
    public void setName(String name) { this.name = name; }
    public void setMetacritic(Integer metacritic) { this.metacritic = metacritic; }
    public void setPlaytime(int playtime) { this.playtime = playtime; }

    @Override
    public String toString() {
        return "Juego{name='" + name + "', metacritic=" + metacritic + ", playtime=" + playtime + "}";
    }
}
