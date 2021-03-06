package br.com.viana.hal.tables.tableDef

import javax.persistence.Embeddable

@Embeddable
class TableColumnDefinition implements Serializable {

    int position

    String name

    String label

    String selector

    Class<?> type
}
