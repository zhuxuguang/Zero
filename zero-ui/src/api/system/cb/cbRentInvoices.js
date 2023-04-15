import request from '@/utils/request'

// 查询租金录入单据列表
export function listCbRentInvoices(query) {
  return request({
    url: '/system/cb/cbRentInvoices/list',
    method: 'get',
    params: query
  })
}

// 查询租金录入单据详细
export function getCbRentInvoices(id) {
  return request({
    url: '/system/cb/cbRentInvoices/' + id,
    method: 'get'
  })
}

// 新增租金录入单据
export function addCbRentInvoices(data) {
  return request({
    url: '/system/cb/cbRentInvoices',
    method: 'post',
    data: data
  })
}

// 修改租金录入单据
export function updateCbRentInvoices(data) {
  return request({
    url: '/system/cb/cbRentInvoices',
    method: 'put',
    data: data
  })
}

// 删除租金录入单据
export function delCbRentInvoices(id) {
  return request({
    url: '/system/cb/cbRentInvoices/' + id,
    method: 'delete'
  })
}


// 查询部门下拉树结构
export function deptTreeSelect() {
  return request({
    url: '/system/cb/cbRentInvoices/deptTree',
    method: 'get'
  })
}


// 审核租金录入单据
export function checkCbRentInvoices(cid) {
  return request({
    url: '/system/cb/cbRentInvoices/check/' + cid,
    method: 'delete'
  })
}


// 反审核租金录入单据
export function onCheckCbRentInvoices(id) {
  return request({
    url: '/system/cb/cbRentInvoices/onCheck/' + id,
    method: 'post'
  })
}
