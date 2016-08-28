package annotation.space.comm_channel;

import annotation.meta_info.Constraints;
import annotation.meta_info.DBTable;
import annotation.meta_info.SQLInteger;
import annotation.meta_info.SQLString;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 8/28/16.
 */
@DBTable(name = "tb_mail")
public class Mail {

    @SQLInteger(constraints = @Constraints(primaryKey = true, nullAble = false, unique = true, autoIncrement = true))
    private Integer pkid;

    @SQLString(length = 50)
    private String address;

    @SQLString(length = 100)
    private String content;

}