import request from '@/utils/request'

// 查询费用明细列表
export function listCbExpenseDetail(query) {
  return request({
    url: '/system/cb/cbExpenseDetail/list',
    method: 'get',
    params: query
  })
}

// 查询费用明细详细
export function getCbExpenseDetail(id) {
  return request({
    url: '/system/cb/cbExpenseDetail/' + id,
    method: 'get'
  })
}

// 新增费用明细
export function addCbExpenseDetail(data) {
  return request({
    url: '/system/cb/cbExpenseDetail',
    method: 'post',
    data: data
  })
}

// 修改费用明细
export function updateCbExpenseDetail(data) {
  return request({
    url: '/system/cb/cbExpenseDetail',
    method: 'put',
    data: data
  })
}

// 删除费用明细
export function delCbExpenseDetail(id) {
  return request({
    url: '/system/cb/cbExpenseDetail/' + id,
    method: 'delete'
  })
}
