package naakcii.by.api.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

//TODO
@org.hibernate.annotations.GenericGenerator(
        name = "ID_GENERATOR",
        strategy = "enhanced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "NAAKCIIBY_ENCHANCED_SEQUENCE"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "initial_value",
                        value = "1000"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "increment_size",
                        value = "100"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "optimizer",
                        value = "pooled-lo"
                )
        })
@org.hibernate.annotations.GenericGenerator(
        name = "productInfoKeyGenerator",
        strategy = "foreign",
        parameters =
        @org.hibernate.annotations.Parameter(name = "property", value = "product")
)
public class NamingStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final long serialVersionUID = -2602880813200030898L;

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier("T_" + name.getText(), name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return new Identifier("F_" + name.getText(), name.isQuoted());
    }

}
