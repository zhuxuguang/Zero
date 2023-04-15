import request from '@/utils/request'

// 查询成本分析报表列表
export function listCbCostAnalysisReport(query) {
  return request({
    url: '/system/cb/cbCostAnalysisReport/list',
    method: 'get',
    params: query
  })
}

// 查询成本分析报表详细
export function getCbCostAnalysisReport(id) {
  return request({
    url: '/system/cb/cbCostAnalysisReport/' + id,
    method: 'get'
  })
}

// 新增成本分析报表
export function addCbCostAnalysisReport(data) {
  return request({
    url: '/system/cb/cbCostAnalysisReport',
    method: 'post',
    data: data
  })
}

// 修改成本分析报表
export function updateCbCostAnalysisReport(data) {
  return request({
    url: '/system/cb/cbCostAnalysisReport',
    method: 'put',
    data: data
  })
}

// 删除成本分析报表
export function delCbCostAnalysisReport(id) {
  return request({
    url: '/system/cb/cbCostAnalysisReport/' + id,
    method: 'delete'
  })
}

// 主动获取成本分析报表
export function acquireCbCostAnalysisReport() {
  return request({
    url: '/system/cb/cbCostAnalysisReport/acquire',
    method: 'post'
  })
}
