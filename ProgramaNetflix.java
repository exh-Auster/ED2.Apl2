import java.util.Arrays;

public class ProgramaNetflix {
    private String id;
    private String title;
    private String type;
    private String description;
    private int releaseYear;
    private String ageCertification; //TODO: confirm type
    private int runtime;
    private String[] genres; //TODO: confirm type
    private String[] productionCountries; //TODO: confirm type
    private int seasons;
    private String imdbId;
    private Double imdbScore;
    private int imdbVotes;
    private Double tmdbPopularity;
    private Double tmdbScore;

    public ProgramaNetflix(String id, String title, String type, String description, int releaseYear, String ageCertification, int runtime, String[] genres, String[] productionCountries, int seasons, String imdbId, Double imdbScore, int imdbVotes, Double tmdbPopularity, Double tmdbScore) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.releaseYear = releaseYear;
        this.ageCertification = ageCertification;
        this.runtime = runtime;
        this.genres = genres;
        this.productionCountries = productionCountries;
        this.seasons = seasons;
        this.imdbId = imdbId;
        this.imdbScore = imdbScore;
        this.imdbVotes = imdbVotes;
        this.tmdbPopularity = tmdbPopularity;
        this.tmdbScore = tmdbScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getAgeCertification() {
        return ageCertification;
    }

    public void setAgeCertification(String ageCertification) {
        this.ageCertification = ageCertification;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String[] getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(String[] productionCountries) {
        this.productionCountries = productionCountries;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(Double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public Double getTmdbPopularity() {
        return tmdbPopularity;
    }

    public void setTmdbPopularity(Double tmdbPopularity) {
        this.tmdbPopularity = tmdbPopularity;
    }

    public Double getTmdbScore() {
        return tmdbScore;
    }

    public void setTmdbScore(Double tmdbScore) {
        this.tmdbScore = tmdbScore;
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() +
                "\nTítulo: " + this.getTitle() +
                "\nTipo: " + this.getType() +
                "\nDescrição: " + this.getDescription() +
                "\nAno de lançamento: " + this.getReleaseYear() +
                "\nClassificação: " + this.getAgeCertification() +
                "\nDuração: " + this.getRuntime() +
                "\nGêneros: " + Arrays.toString(this.getGenres()) + //TODO
                "\nPaíses: " + Arrays.toString(this.getProductionCountries()) + //TODO
                "\nNúmero de temporadas: " + this.getSeasons() +
                "\nIMDB ID: " + this.getImdbId() +
                "\nIMDB score: " + this.getImdbScore() +
                "\nIMDB votes: " + this.getImdbVotes() +
                "\nTMDB popularity: " + this.getTmdbPopularity() +
                "\nTMDB score: " + this.getTmdbScore();
    }
}