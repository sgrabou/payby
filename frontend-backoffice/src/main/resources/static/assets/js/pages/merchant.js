"use strict";

// Class definition
var KTMerchant = function() {
    // Latest Orders
    var datatableMerchant = function() {
        if ($('#kt_datatable_latest_orders').length === 0) {
            return;
        }

        var datatable = $('.kt-datatable').KTDatatable({
            data: {
                type: 'remote',
                source: {
                    read: {
                        url: 'http://localhost:8060/admin/api/v1/merchant',
                        method: 'GET',
                        contentType: 'application/json',
                    },
                },

                saveState: {
                    cookie: false,
                    webstorage: true
                },
                serverPaging: false,
                serverFiltering: false,
                serverSorting: false
            },

            layout: {
                scroll: true,
                height: 500,
                footer: false
            },

            sortable: true,

            filterable: false,

            pagination: false,

            columns: [{
                field: "",
                title: "#",
                sortable: false,
                width: 40,
                selector: {
                    class: 'kt-checkbox--solid'
                },
                textAlign: 'center'
            },{
                field: "merchantID",
                title: "ID",
            }, {
                field: "userName",
                title: "Merchant",
            }, {
                field: "urlWebsite",
                title: "Site Web",
                width: 100,
            }, {
                field: "merchantStatus",
                title: "Status",
                width: 100,
            }, {
                field: "mobileNumber",
                title: "Téléphone",
                width: 200
            }, {
                field: "Actions",
                width: 80,
                title: "Actions",
                sortable: false,
                autoHide: false,
                overflow: 'visible',
                template: function() {
                    return '\
                        <div class="dropdown">\
                            <a href="javascript:;" class="btn btn-sm btn-clean btn-icon btn-icon-md" data-toggle="dropdown">\
                                <i class="flaticon-more-1"></i>\
                            </a>\
                            <div class="dropdown-menu dropdown-menu-right">\
                                <ul class="kt-nav">\
                                    <li class="kt-nav__item">\
                                        <a href="#" class="kt-nav__link">\
                                            <i class="kt-nav__link-icon flaticon2-expand"></i>\
                                            <span class="kt-nav__link-text">View</span>\
                                        </a>\
                                    </li>\
                                    <li class="kt-nav__item">\
                                        <a href="#" class="kt-nav__link">\
                                            <i class="kt-nav__link-icon flaticon2-contract"></i>\
                                            <span class="kt-nav__link-text">Edit</span>\
                                        </a>\
                                    </li>\
                                    <li class="kt-nav__item">\
                                        <a href="#" class="kt-nav__link">\
                                            <i class="kt-nav__link-icon flaticon2-trash"></i>\
                                            <span class="kt-nav__link-text">Delete</span>\
                                        </a>\
                                    </li>\
                                    <li class="kt-nav__item">\
                                        <a href="#" class="kt-nav__link">\
                                            <i class="kt-nav__link-icon flaticon2-mail-1"></i>\
                                            <span class="kt-nav__link-text">Export</span>\
                                        </a>\
                                    </li>\
                                </ul>\
                            </div>\
                        </div>\
                    ';
                }
            }]
        });
    }


    return {
        // Init demos
        init: function() {
            // init charts



            // datatables
            datatableMerchant();



            
            // demo loading
            var loading = new KTDialog({'type': 'loader', 'placement': 'top center', 'message': 'Loading ...'});
            loading.show();

            setTimeout(function() {
                loading.hide();
            }, 3000);
        }
    };
}();

// Class initialization on page load
jQuery(document).ready(function() {
    KTMerchant.init();
});