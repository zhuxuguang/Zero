import request from '@/utils/request'

// 查询物资领用报表视图列表
export function listCbReceiptGoodsReportView(query) {
  return request({
    url: '/system/cbReceiptGoodsReportView/list',
    method: 'get',
    params: query
  })
}

// 查询物资领用报表视图详细
export function getCbReceiptGoodsReportView(type) {
  return request({
    url: '/system/cbReceiptGoodsReportView/' + type,
    method: 'get'
  })
}

// 新增物资领用报表视图
export function addCbReceiptGoodsReportView(data) {
  return request({
    url: '/system/cbReceiptGoodsReportView',
    method: 'post',
    data: data
  })
}

// 修改物资领用报表视图
export function updateCbReceiptGoodsReportView(data) {
  return request({
    url: '/system/cbReceiptGoodsReportView',
    method: 'put',
    data: data
  })
}

// 删除物资领用报表视图
export function delCbReceiptGoodsReportView(type) {
  return request({
    url: '/system/cbReceiptGoodsReportView/' + type,
    method: 'delete'
  })
}
