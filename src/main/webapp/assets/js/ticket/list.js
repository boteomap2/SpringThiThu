function operateFormatter(value, row, index) {
    return [
        '<a class="update mr-2" href="javascript:void(0)" title="Update">',
        '<i class="far fa-edit fa-2x fa-fw"></i>',
        "</a>"
    ].join("");
}

window.operateEvents = {
    "click .update": function (e, value, row, index) {
        window.location.href = `/quanly/ticket/update?id=${row.maDK}`;
    },
};