package knf.animeflv;

/**
 * Created by Jordy on 12/08/2015.
 */
public enum TaskType {
    GET_INICIO(1), GET_HTML1(2), GET_INFO(3), GET_TITULO(4), GET_URL(5), VERSION(6);

    int value;

    private TaskType(int value) {
        this.value = value;
    }
}