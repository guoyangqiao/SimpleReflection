package annotation.space.comm_channel_data;

import annotation.meta_info.Constraints;
import annotation.meta_info.DBTable;
import annotation.meta_info.SQLInteger;
import annotation.meta_info.SQLString;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 8/28/16.
 */
@DBTable(name = "tb_contact")
public class Contact {

    @SQLInteger(constraints = @Constraints(primaryKey = true, nullAble = false, unique = true, autoIncrement = true))
    private Integer pkid;

    @SQLString(length = 50, defaultValue = "尼玛")
    private String firstName;

    @SQLString(length = 100, defaultValue = "王")
    private String lastName;

}