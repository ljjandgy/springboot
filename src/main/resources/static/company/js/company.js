/*var Company = {
    id: "CompanyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    pageSize:20,
    pageNumber:1
};

layui.use('table', function() {
    var table = layui.table;
    //第一个实例
    table.render({
        elem : '#CompanyTable',
        height : 615,
        url : '/company/list', //数据接口
        page : true, //开启分页
        striped: true,//是否显示行间隔色
        pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        pageSize:20,
        search: false,                      //是否显示表格搜索
        strictSearch: true,
        showRefresh: true,                  //是否显示刷新按钮
        clickToSelect: true,                //是否启用点击选中行
        cols : [ [ //表头
            {
                field : 'compid',
                title : '公司编号',
                width : 80,
                fixed : 'left',
                visible : false
            }, {
                field : 'compname',
                title : '公司名称',
                width : 80
            }, {
                field : 'adress',
                title : '地址',
                width : 160,
                sort : true
            }, {
                field : 'tel',
                title : '电话',
                width : 160
            }, {
                field : 'email',
                title : '电子邮件',
                width : 80
            }, {
                field : 'boss',
                title : '法人',
                width : 80
            }, {
                field : 'bandnumber',
                title : '公司账号',
                width : 80
            } ] ]
    });
});*/

var Company = {
    id: "CompanyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    pageSize:20,
    pageNumber:1
};
layui.use('table', function(){
    var layer = layui.layer
        ,table = layui.table
        ,$ = layui.jquery;

    Company.queryParams = function() {
        var CompanyCode = $('#companyname').val();
        var temp = {
            companyname: companyname
        };
        return temp;
    }

    /**
     * 初始化表格的列
     */
    Company.initColumn = function () {
            return [
                {checkbox:true, halign:'center',align:"center",width: 50},
                {title: '序号',align:"center" ,halign:'center',width:50 ,formatter: function (value, row, index) {return (Company.pageNumber-1)*Company.pageSize +1 +index ;}},
                {title: '主键', field: 'compid', align: 'center',halign:'center',visible:false},
                {title: '公司名称', field: 'compname', align: 'left',halign:'center',width:400,
                    formatter: function (value, row, index) {return "<span style='color:blue;cursor:pointer'>"+value+"</span>"}
                },
                {title: '发布时间', field: 'adress', align: 'center',halign:'center'},
                {title: '审核人', field: 'tel', align: 'center',halign:'center'},
                {title: '回复人', field: 'email', align: 'center',halign:'center'},
                {title: '回复人', field: 'boss', align: 'center',halign:'center'},
                {title: '状态', field: 'bandnumber', align: 'center',halign:'center'}
            ];
    };


    /**
     * 查询列表
     */
    Company.search = function () {
        $('#CompanyTable').bootstrapTable('refresh', {
            query: Company.queryParams()
        });
    };

    $(function () {
        var defaultColunms = Company.initColumn();

        $('#CompanyTable').bootstrapTable({
            dataType:"json",
            url:'/company/list',
            pagination:true,
            pageList:[10,20,50,100],
            striped:true,
            pageNumber:1,
            queryParamsType:'',
            columns: defaultColunms,
            height:200,
            onClickRow:function (e,row,td) {
                var inputC = row[0].cells[0].children[0];
                if(td=="compname"){
                    var index = layer.open({
                        type: 2,
                        title: '详细',
                        area: ['750px', '420px'], //宽高
                        fix: false, //不固定
                        maxmin: false,
                        content:  '/company/company_detail/' + e.compid
                    });
                    this.layerIndex = index;
                    $('#CompanyTable').bootstrapTable('refresh');
                }else{
                    inputC.click();
                }
            },
            onPageChange:function(number, size){Company.pageNumber = number ; Company.pageSize = size}
        });
    })

});



